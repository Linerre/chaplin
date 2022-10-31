(ns client.events.search
  "Events for the search box"
  (:require
   [ajax.core :as ajax]
   ;; [day8.re-frame.http-fx]
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
       (assoc :user-input nil)          ; user query text
       (assoc :checked {:chapter false,
                        :section false,
                        :pages   false,
                        :lesson  false,
                        :part    false})
       (assoc :filter-on? false))
   ))

;; -- Event Handlers -----------------------------
(re-frame/reg-event-db
 :search/user-input                     ; when user types in the search box
 (fn [db [_ input]]
   (.log js/console "User is typing ... ")
   (assoc db :user-input input)))

;; fake one for development ------------------------
(re-frame/reg-event-fx
 :search/user-query-dev                     ; when user presses `Enter' key
 (fn [{db :db} [_ user-q]]
   {:db  (assoc db :user-query user-q)
    :dispatch [:router/eh-push-state :search nil {:q user-q}]
    }
   ))

;; real one for production -------------------------
(re-frame/reg-event-fx
 :search/user-query                     ; when user presses `Enter' key
 (fn [{db :db} [_ user-q]]
   {:http-xhrio {:method          :get,
                 :uri             "/search",
                 :timeout         8000,
                 :params          {:q user-q},
                 :format          (ajax/url-request-format),
                 :response-format (ajax/ring-response-format),
                 :on-success      [:search/good-response],
                 :on-failure      [:search/bad-response]},
    :db  (assoc db :loading? true)
    :dispatch [:router/eh-push-state :search nil {:q user-q}]
    }
   ))

(re-frame/reg-event-db
 :search/good-response
 (fn [db [_ resp]]                  ; response is implicitly passed to the
   (-> db                           ; on-success dispatcher
    (assoc :loading? false)
    (assoc :data (:body resp))
    )
   ))

(re-frame/reg-event-db
 :search/bad-response
 (fn [db [_ response]]
   (-> db
    (assoc :loading? false)
    (assoc :bad-response (str "Bad Response!")))))

(comment
  (ajax/GET "/search" {:params {:q "google"},
                       :format (ajax/url-request-format),
                       ;; :response-format (ajax/text-request-format)
                       :handler #(.log js/console %)}))
