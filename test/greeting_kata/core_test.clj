(ns greeting-kata.core-test
  (:require [clojure.test :refer :all]
            [greeting-kata.core :refer :all]))

(deftest test-greet
  (testing "Greets name"
    (is (= "Hello, Paco." (greet "Paco")))
    (is (= "Hello, Josefina." (greet "Josefina"))))
  (testing "Handles nulls"
    (is (= "Hello, my friend." (greet))))
  (testing "Handles shouts"
    (is (= "HELLO JERRY!" (greet "JERRY"))))
  (testing "Handles two names"
    (is (= "Hello, Jill and Joe." (greet "Jill" "Joe"))))
  (testing "Handles arbitrarily number of names"
    (is (= "Hello, Amy, Brian, and Charlotte." (greet "Amy", "Brian", "Charlotte"))))
  (testing "Handles two greetings"
    (is (= "Hello, Amy and Charlotte. AND HELLO BRIAN!" (greet "Amy", "BRIAN", "Charlotte")))))

(deftest test-split
  (testing "Splits"
    (is (= [["Paco" "Jimmy"] ["PEPE"]] (split-salutes-and-shouts ["Paco" "PEPE" "Jimmy"])))))