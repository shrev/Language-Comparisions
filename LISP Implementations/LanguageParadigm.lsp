(defclass food () ())

(defclass seafood (food) ())
(defclass shrimp (seafood) ())
(defclass prawn (shrimp) ())

(defclass fruit (food)
  ((color :initarg :color
          :reader fruit-color)
   (price :initarg :price
          :accessor fruit-price)))

(defclass apple (fruit) ()
  (:default-initargs
      :color 'red))

(defclass orange (fruit) ())


(defmethod prepare ((item apple))
 (core item))

(defmethod prepare ((item orange))
 (peel item))

(defmethod prepare ((item shrimp))
 (peel item)
 (devein item))

(defmethod core (item)
 (format t "~&Coring ~S~%" item))

(defmethod devein (item)
 (format t "~&Deveining ~S~%" item))

(defmethod peel (item)
 (format t "~&Peeling   ~S~%" item))

(defmethod wash (item)
 (format t "~&Washing   ~S~%" item))

(defmethod prepare ((item prawn))
  (wash item)
  (call-next-method))


(prepare (make-instance 'prawn)) 
(make-instance 'apple :price 25)     ;creates a 25 cent red apple
(make-instance 'apple :color 'green) ;creates an un-priced green apple
