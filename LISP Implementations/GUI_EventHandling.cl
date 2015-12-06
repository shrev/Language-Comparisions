
(defclass my-window (frame-window)())

(defun my-gui ()
  (let* ((window (make-window :my-window
           :class 'my-window
           :exterior nil
           :interior (make-box 358 101 1231 462)
           :border nil
           :child-p nil
           :close-button t
           :font
           (make-font-ex :swiss "Arial / ANSI" 12)
           :form-state :normal
           :maximize-button t
           :minimize-button t
           :name :form1
           :pop-up nil
           :resizable nil
           :scrollbars nil
           :state :normal
           :system-menu t
           :title nil
           :title-bar t
           :dialog-items
           (list (make-instance 'static-text
                   :font
                   (make-font-ex nil "BD Engraved Black / ANSI" 21)
                   :height 50
                   :justification :center
                   :left 11
                   :name :static-text-2
                   :top 114
                   :value ""
                   :width 851)
                 (make-instance 'static-text
                   :font
                   (make-font-ex :roman "Century / ANSI" 29 '(:bold))
                   :height 46
                   :justification :center
                   :left 1
                   :name :static-text-1
                   :top 24
                   :value "GUI AND EVENT HANDLING"
                   :width 870)
                 (make-instance 'group-box
                   :contained-widgets
                   (list :static-text-2)
                   :font
                   (make-font-ex nil "Segoe UI / Default" 12)
                   :height 72
                   :left 1
                   :on-mouse-in 'display-string
                   :on-mouse-moved 'display-string2
                   :on-mouse-out 'delete-string
                   :name :group-box-1
                   :title "MOVE MOUSE OVER THE PANEL"
                   :top 100
                   :width 870)
                   
                 (make-instance 'editable-text
                   :font
                   (make-font-ex nil "Segoe UI / Default" 12)
                   :left 1
                   :virtual-key-down 'do-job
                   :name :editable-text-1
                   :top 285
                   :value ""
                   :width 870)
                
                 (make-instance 'button
                   :font
                   (make-font-ex nil "Segoe UI / Default" 12)
                   :left 1
                   :on-click 'clear-text
                   :name :button-5
                   :title "Clear Text"
                   :top 241
                   :width 870)))))
    window))

(defun display-string (widget new-value old-value)
  (declare (ignore new-value old-value))
  (let ((val (find-sibling :static-text-2 widget)))
    (setf (value val) "This is On-mouse-in Event" ))
  (window-message (parent widget) "")
  t)

(defun display-string2 (widget new-value old-value)
  (declare (ignorable new-value old-value))
  (let ((val (find-sibling :static-text-2 widget)))
    (setf (value val) "This is On-mouse-in Event" ))
  (window-message (parent widget) "")
  t)

(defun delete-string (widget new-value old-value)
  (declare (ignorable new-value old-value))
  (let ((val (find-sibling :static-text-2 widget)))
    (setf (value val) " " ))
  (window-message (parent widget) "")
  t)

(defun clear-text (dialog widget)
  (declare (ignorable dialog widget))
  (let ((val2 (find-sibling :editable-text-1 widget)))
    (setf (value val2) " " )) 
  (window-message (parent widget) "")
  t)

