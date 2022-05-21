(ns client.events.search
  "Events for the search box"
  (:require
   [ajax.core :as ajax]
   [day8.re-frame.http-fx]
   [re-frame.core :as re-frame]))


;; -- Initialize ---------------------------------
;; The map returned will be loaded into `app-db'.
;; `app-db' is defined by re-frame, basically a r/atom
;; At the very begining, `app-db' just containings {}
;; Router event will initialize the db first
;; so this initilizer will add to it
(re-frame/reg-event-db
 :search/initialize-query
 (fn [db _]
   (-> db
       (assoc :user-input nil)    ;; user query text
       (assoc :part-type nil))    ;; chapter, section, ...
   ))

;; -- Event Handlers -----------------------------
(re-frame/reg-event-db
 :search/user-input                     ; when user types in the search box
 (fn [db [_ input]]
   (.log js/console "User is typing ... ")
   (assoc db :user-input input)))

(re-frame/reg-event-fx
 :search/user-query                     ; when user presses `Enter' key
 (fn [{db :db} [_ user-q]]
   {:http-xhrio {:method          :get,
                 :uri             "/search",
                 ;; :uri             "https://reqres.in/api/users?page=2",
                 :timeout         8000,
                 :params          {:q user-q},
                 ;; :format          (ajax/text-request-format),
                 :response-format (ajax/json-response-format {:keywords? true}),
                 :on-success      [:search/good-response],
                 :on-failure      [:search/bad-response]},
    :db  (assoc db :loading? true)
    :dispatch [:router/eh-push-state :search]
    }
   ))

(re-frame/reg-event-db
 :search/good-response
 (fn [db [_ response]]
   (-> db
    (assoc :loading? false)
    (assoc :data (js->clj response)))))

(re-frame/reg-event-db
 :search/bad-response
 (fn [db [_ response]]
   (-> db
    (assoc :loading? false)
    (assoc :bad-response (str "Bad Response!")))))
