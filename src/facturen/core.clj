(ns facturen.core
  (:require [clojure.java.io :as io]
            [clojure.core.match :refer [match]]
            [instaparse.core :as insta]
            [clj-pdf.core :as pdf]))

(defn parser []
  (insta/parser (io/resource "facturen.bnf")))

(defn- lst [& xs]
  [(keyword (first xs)) (rest xs)])

(defn transform [tree]
  (insta/transform
    {:S (fn [& xs] (rest xs))
     :paragraph lst
     :inline lst
     :cell lst}
    tree))

(defn testing []
  (let [p (parser)
        s (slurp (io/resource "example.txt"))]
    (-> s p transform)))
