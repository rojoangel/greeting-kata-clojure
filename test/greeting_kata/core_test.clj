(ns greeting-kata.core-test
  (:require [clojure.test :refer :all]
            [clojure.string :as str]
            [greeting-kata.core :refer :all]))

(defn calculate-name [name]
  (cond
    (nil? name) "my friend"
    (sequential? name) (if (> (count name) 2)
                         (str/join ", and " [(str/join ", " (butlast name)) (last name)])
                         (str/join " and " name))
    :else name))

(defn greet [name]
  (let [name (calculate-name name)]
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
    (is (= "Hello, Jill and Joe." (greet ["Jill" "Joe"]))))
  (testing "Handles arbitrarily number of names"
    (is (= "Hello, Amy, Brian, and Charlotte." (greet ["Amy", "Brian", "Charlotte"])))))
