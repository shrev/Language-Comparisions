(defun isPalindrome()
(format t "Enter the string (in \"\") : ")
(setf x (read)) 
(if(string= x (reverse x))
    (format t "Palindrome")
    (format t "Not a Palindrome")
    )                                                                           
)

(defun findVolume()
(princ "Enter Edge length: ")
(setq edge (read))
(setq area (expt edge 3))
(princ "Area: ")
(write area))
