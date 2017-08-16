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
   (let [[lower upper] (split (conj names name))
         salutations (apply salute lower)
         shouts (apply shout upper)]
     (str/join " AND " (remove str/blank? [salutations shouts])))))
