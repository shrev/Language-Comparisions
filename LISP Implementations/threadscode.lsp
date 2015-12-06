;;; This is the IDE's built-in-editor, where you create and edit
;;; lisp source code.  You could use some other editor instead,
;;; though the IDE's menu-bar commands would not be applicable there.
;;; 
;;; This editor has a tab for each file that it's editing.  You can
;;; create a new editor buffer at any time with the File | New command.
;;; Other commands such as Search | Find Definitions will create
;;; editor buffers automatically for existing code.
;;; 
;;; You can use the File | Compile and Load command to compile and
;;; load an entire file, or compile an individual definition by
;;; placing the text cursor inside it and using Tools | Incremental
;;; Compile.  You can similarly evaluate test expressions in the
;;; editor by using Tools | Incremental Evaluation; the returned
;;; values and any printed output will appear in a lisp listener
;;; in the Debug Window.
;;; 
;;; For a brief introduction to other IDE tools, try the
;;; Help | Interactive IDE Intro command.  And be sure to explore
;;; the other facilities on the Help menu.

(in-package :cl-user)  
;; in the IDE (in-package :cg-user)
(require :process)
 
(defun factorial (n) (if (< n 2) n (* n (factorial (1- n)))))
 
;; This lock is used to prevent output interleaving.
(defvar moby-output-lock (mp:make-process-lock))
 
;; Print to the stream the number of trailing
;; zeros in (factorial n) from n=from up to n=to.
;; This is a *very* inefficient way to do this computation,
;; but the point is to make it run slow enough to see.
 
(defun process-test (stream from to)
  (do ((n from (1+ n))) 
      ((>= n to)) 
    (do ((x (factorial n) (/ x 10)) 
         (zeros -1 (1+ zeros))) 
        ((not (integerp x)) 
         (mp:with-process-lock (moby-output-lock) 
            (format stream "factorial(~d) has ~d trailing zeros~%"
                    n zeros)))))) 
 
;; This starts three processes in parallel. 
;; The original Lisp listener returns immediately, 
;; and will accept types forms while the other processes run. 
 
(defun moby-process-test () 
  (mp:process-run-function "Test 1" #'process-test t 400 440)
  (mp:process-run-function "Test 2" #'process-test t 440 470)
  (mp:process-run-function "Test 3" #'process-test t 470 400) 
  t) 
 
;; Make sure factorial itself is compiled 
;; because large factorials exceed the interpreter's stack. 
 
(unless (compiled-function-p #'factorial) (compile 'factorial)) 
 
(format t "Type (moby-process-test) to test multi-processing.~%") 

