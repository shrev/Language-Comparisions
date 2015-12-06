(define-condition on-division-by-zero (error)
   ((message :initarg :message :reader message))
)
   
(defun handle-infinity ()
  
  (princ "Enter the Dividend : ")
  (setq value1 (read))
  (princ "Enter the Divisor  : ")
  (setq value2 (read))

   (restart-case
      (let ((result 0))
         (setf result (division-function value1 value2))
         (format t "Value: ~a~%" result)
      )
   )
)
     
(defun division-function (value1 value2)
   (restart-case
      (if (/= value2 0)
         (/ value1 value2)
         (error 'on-division-by-zero :message "Denominator is zero; Please retry")
      )

      (recalc () (handle-infinity))
    )
  )


(handler-bind
   (
      (on-division-by-zero
         #'(lambda (c)
            (format t "error signaled: ~a~%" (message c))
            (invoke-restart 'recalc)
         )
      )
   )
   (handle-infinity)
)

