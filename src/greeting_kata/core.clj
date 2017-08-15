(ns greeting-kata.core
  (:require [clojure.string :as str]))

(defn join-names [names]
  (if (> (count names) 2)
    (str/join ", and " [(str/join ", " (butlast names)) (last names)])
    (str/join " and " names)))

(defn uppercase? [word]
  (= word (str/upper-case word)))

(defn split [names]
  (let [{lowers false
         uppers true} (group-by uppercase? names)]
    [lowers uppers]))

(defn salute [names]
  (when (not (empty? names))
    (str "Hello, " names ".")))

(defn shout [names]
  (when (not (empty? names))
    (str "HELLO " names "!")))

(defn greet [names]
  (if (nil? names)
    (salute "my friend")
    (let [names-list (if (sequential? names) names [names])
          [lower upper] (split names-list)
          salutations (salute (join-names lower))
          shouts (shout (join-names upper))]
      (str/join " AND "  (remove str/blank? [salutations shouts])))))
