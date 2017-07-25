(ns greeting-kata.core-test
  (:require [clojure.test :refer :all]
            [greeting-kata.core :refer :all]))

(defn greet [name]
  "Hello, Paco.")


(deftest test-greet
  (testing "Greets name"
    (is (= "Hello, Paco." (greet "Paco")))))
