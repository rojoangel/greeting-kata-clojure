(ns greeting-kata.core-test
  (:require [clojure.test :refer :all]
            [greeting-kata.core :refer :all]))

(defn greet [name]
  (let [name (if (nil? name) "my friend" name)]
    (str "Hello, " name ".")))


(deftest test-greet
  (testing "Greets name"
    (is (= "Hello, Paco." (greet "Paco")))
    (is (= "Hello, Josefina." (greet "Josefina"))))
  (testing "Handles nulls"
    (is (= "Hello, my friend." (greet nil)))))
