(ns witan.reparaturen
  (:require [schema.core :as s]
            [schema-contrib.core :as c]
            [kixi.lapita :as kl]
            [kixi.lapita.plot :as plot]))

(def HousingRepairSchema
  {:repair-number s/Str
   :property-reference s/Str
   :original-target-date c/Date
   :target-end-date c/Date
   :logged-date c/Date
   :termination-date c/Date
   :priority-code s/Int
   :workforce-name s/Str
   :description-for-code s/Str})

(def TestData
  {:col-1 s/Int
   :col-2 s/Str
   :col-3 java.lang.Double})

(comment (def repairs-data (kl/csv-to-maps-coll "data/historic-repairs-2014-2015.csv"))

         (def repairs-ds (kl/csv-to-dataset "data/historic-repairs-2014-2015.csv"))

         (def repairs-ds-cleaned (kl/csv-to-dataset "data/historic-repairs-2014-2015.csv"
                                                    HousingRepairSchema
                                                    {:print-errors true
                                                     :remove-errors true}))

         (-> repairs-ds-cleaned
             (kl/count-elements-in-column :property-reference :count-repairs-per-property)
             (kl/count-elements-in-column :count-repairs-per-property :occurences)
             (plot/plot-bar-chart :count-repairs-per-property :occurences
                                  "data/occurences-of-n-repairs.svg"
                                  {:plot-width 900 :plot-height 500}))

         (def test-data-1 [{:col-1 "1" :col-2 "a" :col-3 "1.1"}
                           {:col-1 "2" :col-2 "b" :col-3 "bar"}
                           {:col-1 "foo" :col-2 "c" :col-3 "1.3"}])

         (def test-data-2 [{:col-1 "1" :col-2 "a" :col-3 "1.1"}
                           {:col-1 "2" :col-2 "b" :col-3 "1.2"}
                           {:col-1 "3" :col-2 "c" :col-3 "1.3"}]))
