(ns witan.reparaturen
  (:require [schema.core :as s]
            [schema-contrib.core :as c]
            [kixi.lapita :as kl]))

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

(comment (def repairs-data (kl/csv-to-maps-coll "data/historic-repairs-2014-2015.csv"))

         (def repairs-ds (kl/csv-to-dataset "data/historic-repairs-2014-2015.csv"))

         (def repairs-ds-cleaned (kl/csv-to-dataset "data/historic-repairs-2014-2015.csv"
                                                    HousingRepairSchema
                                                    {:print-errors true
                                                     :remove-errors true})))
