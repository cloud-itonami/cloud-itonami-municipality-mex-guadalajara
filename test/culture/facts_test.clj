(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest guadalajara-has-culture-basis
  (let [sb (facts/spec-basis "guadalajara")]
    (is (= 10 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "guadalajara" (:culture/municipality %)) sb))
    (is (every? #(= "MEX" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "monterrey")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["guadalajara" "monterrey"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["monterrey"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 4 (count (facts/by-kind "guadalajara" :dish))))
  (is (= ["guadalajara.beverage.tequila" "guadalajara.beverage.tejuino"]
         (mapv :culture/id (facts/by-kind "guadalajara" :beverage))))
  (is (empty? (facts/by-kind "guadalajara" :craft)))
  (is (empty? (facts/by-kind "monterrey" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
