(ns client.events.result
  (:require
   [re-frame.core :as rf]))

(rf/reg-event-db
 :result/enabled-filter
 (fn [db _]
   (if (some true? (vals (:checked db))) ; as long as on checkbox checked
     (assoc db :enabled-filter? true)    ; filter enabled
     (assoc db :enabled-filter? false))  ; otherwise disabled
   ))


(rf/reg-event-db
 :result/checked-type
 (fn [db [_ part-type]]
   (if-let [checked? (get-in db [:checked part-type])] ; if unchecked (false)
     (assoc-in db [:checked part-type] false)          ; keep it unchecked
     (assoc-in db [:checked part-type] true))          ; otherwise check it

   ))
