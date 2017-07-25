(ns greeting-kata.core-test
  (:require [clojure.test :refer :all]
            [clojure.string :as str]
            [greeting-kata.core :refer :all]))

(defn join-names [names]
  (if (> (count names) 2)
    (str/join ", and " [(str/join ", " (butlast names)) (last names)])
    (str/join " and " names)))

(defn uppercase? [word]
  (= word (str/upper-case word)))

(defn split [names]
  [(filter (complement uppercase?) names)
   (filter uppercase? names)])

(defn salute [names]
  (str "Hello, " names "."))

(defn shout [names]
  (str "HELLO " names "!"))

(defn greet [names]
  (if (nil? names)
    (salute "my friend")
    (let [names-list (if (sequential? names) names [names])
        [lower upper] (split names-list)
        salutations (if (empty? lower) [] [(salute (join-names lower))])
        shouts (if (empty? upper) [] [(shout (join-names upper))])]
    (str/join " AND " (concat salutations shouts)))))

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
    (is (= "Hello, Amy, Brian, and Charlotte." (greet ["Amy", "Brian", "Charlotte"]))))
  (testing "Handles two greetings"
    (is (= "Hello, Amy and Charlotte. AND HELLO BRIAN!" (greet ["Amy", "BRIAN", "Charlotte"])))))

(deftest test-split
  (testing "Splits"
    (is (= [["Paco" "Jimmy"] ["PEPE"]] (split ["Paco" "PEPE" "Jimmy"])))))