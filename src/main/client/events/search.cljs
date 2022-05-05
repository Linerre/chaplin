(ns client.events.search
  "Events when users click on the search button.
  The events registered under this name spaces
  will be dispatched in components.search"
  (:require
   [reagent.core :as r]
   [re-frame.core :as re-frame]))


;; -- Initialize ---------------------------------
;; This init-db event is an exception
;; It initializes the app-db ONLY
;; A view fn is needed to render the initial data!
(re-frame/reg-event-db
 :search/init-db
 (fn [_ _]
   {:clue "", ;; user input in the search box
    :part  "chapter"})) ;; part type: chapter, section ...

;; The map returned will be loaded into `app-db'.
;; `app-db' is defined by re-frame. It's basically a r/atom
;; At the very begining, `app-db' just containings {}

;; -- Event Handlers -----------------------------
;; Register event handlers with `reg-event-db'
;; `reg-event-db' can have ONE side effect only
;; To have many, use reg-event-fx
(re-frame/reg-event-db
 :search/input
 (fn [db [_ usr-input]]
   (assoc db :clue usr-input)))

(re-frame/reg-event-db
 :search/part
 (fn [db [_ usr-sel]]
   (assoc db :part usr-sel)))

(re-frame/reg-event-db
 :search/click
 (fn [_ _]
   (.alert js/window "You clicked the button!")))

;; -- query --------------------------------------
;; Think of query fns as event listeners
(re-frame/reg-sub
 :search/input-change ; its name
 (fn [db _]
   (:clue db)))       ; listener fn only cares the :clue

(re-frame/reg-sub
 :search/part-sel
 (fn [db _]
   (:part db)))
