(ns greeting-kata.core
  (:require [clojure.string :as str]))

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
