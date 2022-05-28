(ns client.subs.result
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
 :result/checked?
 (fn [db [_ part-type]]
   (get-in db [:checked part-type])))

(rf/reg-sub
 :result/filter-on?
 (fn [db _]
   (:filter-on? db)))
