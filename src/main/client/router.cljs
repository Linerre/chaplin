(ns client.router
  "Client-side router"
  (:require
   [client.components.nav :refer [top-nav]]
   [client.components.footer :refer [footer-frame]]
   [client.pages.about :refer [about-page]]
   [client.pages.index :refer [index-page]]
   [re-frame.core :refer [dispatch subscribe]]
   [reitit.core :as rc]
   [reitit.frontend :as rf]
   [reitit.frontend.easy :as rfe]
   ))

;; frontend routes
(def routes
  ;; ::index => :curr-ns/index
  ;; == client.router/index
  [
   ["/"
    {:name :home,
     :view index-page,
     :text "Home",
     :controllers
     [{:start (fn [& params]
                (.log js/console "Entering the index.")),
       :stop  (fn [& params]
                (.log js/console "Leaving the index."))}]
     }]

   ["/about" {:name :about,
              :view about-page,
              :text "About",
              :controllers
              [{:start (fn [& params]
                         (.log js/console "Entering the about.")),
               :stop  (fn [& params]
                        (.log js/console "Leaving the about."))}]}]

   ])

;; router fn optionally accepts a 3rd arg
;; which is a map for router configuration
(def router
  (rf/router routes {:data {}}))

;; on-navigate fn as 2nd arg for rfe/start!
(defn on-navigate [new-match]
  (when new-match
    (dispatch [:router/navigated new-match])))

;; to run before the app-mounting
(defn init-router []
  (rfe/start!
   router
   on-navigate
   {:use-fragment true}))

;; At the very beginning, there is just nil in db as to route
;; But there must be the index page first, then users can try
;; to click and navigate through the top bar.
(defn router-component []
  (let [current-route @(subscribe [:router/current-route])
        view (or (get-in current-route [:data :view])
                 index-page)]
    [:div#app.w-screen.min-h-screen.relative
     [top-nav :home :about]
     ;; [:h1 "Why my site doesn't work?!"]
     [view current-route]
     ;; (when current-route ;;   )
     [footer-frame]]
    )
  )
