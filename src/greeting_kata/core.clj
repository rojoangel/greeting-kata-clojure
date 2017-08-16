(ns greeting-kata.core
  (:require [clojure.string :as str]))

(defn join-names [names]
  (if (> (count names) 2)
    (str/join ", and " [(str/join ", " (butlast names)) (last names)])
    (str/join " and " names)))

(defn join-greets [salutations shouts]
  (str/join " AND " (remove str/blank? (vector salutations shouts))))

(defn uppercase? [word]
  (= word (str/upper-case word)))

(defn split-salutes-and-shouts [names]
  (let [{saluted false
         shouted true} (group-by uppercase? names)]
    (vector saluted shouted)))

(defn salute
  ([]
    (salute "my friend"))
  ([name]
   (str "Hello, " name "."))
  ([name & other-names]
   (let [names (conj other-names name)]
     (salute (join-names names)))))

(defn shout
  ([]
    nil)
  ([name]
   (str "HELLO " name "!"))
  ([name & other-names]
   (let [names (conj other-names name)]
     (shout (join-names names)))))

(defn greet
  ([]
   (salute))
  ([name]
    (if (uppercase? name)
      (shout name)
      (salute name)))
  ([name & names]
   (let [[saluted shouted] (split-salutes-and-shouts (conj names name))]
     (join-greets (apply salute saluted) (apply shout shouted)))))
