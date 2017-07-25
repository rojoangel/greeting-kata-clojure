(ns greeting-kata.core-test
  (:require [clojure.test :refer :all]
            [clojure.string :as str]
            [greeting-kata.core :refer :all]))

(defn greet [name]
  (let [name (cond
               (nil? name) "my friend"
               (sequential? name) (str/join " and " name)
               :else name)]
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
    (is (= "HELLO JERRY!" (greet "JERRY"))))
  (testing "Handles two names"
    (is (= "Hello, Jill and Joe." (greet ["Jill" "Joe"])))))
