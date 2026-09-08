(ns ordinance.facts-test
  (:require [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest guadalajara-has-spec-basis
  (let [sb (facts/spec-basis "guadalajara")]
    (is (= 2 (count sb)))
    (is (every? #(str/includes? (:ordinance/url %) "guadalajara") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "monterrey")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["guadalajara" "monterrey"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["monterrey"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= 2 (count (facts/by-topic "guadalajara" :governance))))
  (is (empty? (facts/by-topic "guadalajara" :labor)))
  (is (empty? (facts/by-topic "monterrey" :governance))))
