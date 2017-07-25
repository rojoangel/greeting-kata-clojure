(ns greeting-kata.core-test
  (:require [clojure.test :refer :all]
            [greeting-kata.core :refer :all]))

(defn greet [name]
  (if (nil? name)
    "Hello, my friend."
    (str "Hello, " name ".")))


(deftest test-greet
  (testing "Greets name"
    (is (= "Hello, Paco." (greet "Paco")))
    (is (= "Hello, Josefina." (greet "Josefina"))))
  (testing "Handles nulls"
    (is (= "Hello, my friend." (greet nil)))))
