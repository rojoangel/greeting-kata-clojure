(ns greeting-kata.core-test
  (:require [clojure.test :refer :all]
            [clojure.string :as str]
            [greeting-kata.core :refer :all]))

(defn greet [name]
  (let [name (if (nil? name) "my friend" name)]
    (if (= name (str/upper-case name))
      (str "HELLO " name "!")
      (str "Hello, " name "."))))


(deftest test-greet
  (testing "Greets name"
    (is (= "Hello, Paco." (greet "Paco")))
    (is (= "Hello, Josefina." (greet "Josefina"))))
  (testing "Handles nulls"
    (is (= "Hello, my friend." (greet nil))))
  (testing "Handles shouts"
    (is (= "HELLO JERRY!" (greet "JERRY")))))
