(defun list-add (l)
         (let ((sum 0))
           (dolist (i l sum)
             (setq sum (+ i sum)))))
