(ns greeting-kata.core
  (:require [clojure.string :as str]))

(defn join-names
  ([name]
   name)
  ([name other-name]
   (str name " and " other-name))
  ([name other-name & more-names]
   (let [names (conj more-names other-name name)]
     (str (str/join ", " (butlast names)) ", and " (last names)))))

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
     (salute (apply join-names names)))))

(defn shout
  ([]
   nil)
  ([name]
   (str "HELLO " name "!"))
  ([name & other-names]
   (let [names (conj other-names name)]
     (shout (apply join-names names)))))

(defn greet
  ([]
   (salute))
  ([name]
   (if (uppercase? name)
     (shout name)
     (salute name)))
  ([name & more-names]
   (let [[saluted shouted] (split-salutes-and-shouts (conj more-names name))]
     (join-greets (apply salute saluted) (apply shout shouted)))))
