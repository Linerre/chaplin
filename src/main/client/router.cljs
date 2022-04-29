(ns client.router
  "Client-side router"
  (:require
   [client.components.nav :as nav]
   [client.components.footer :as footer]
   [client.pages.about :as about]
   [client.pages.index :as index]
   [reagent.core :as r]
   [reitit.frontend :as rf]
   [reitit.frontend.easy :as rfe]))

;; the state of router
(def match (r/atom nil))

;; on-navigate fn as 2nd arg for rfe/start!
(defn on-navigate [new-match]
  (when new-match (reset! match new-match)))

(defn current-page
  "Index page."
  [index about]
  [:div#app.h-fit.w-screen.mt-4
   [nav/top-nav index about]
   (when @match
     (let [view (get-in @match [:data :view])
           page (get-in @match [:data :text])]
      ;; @match changes then view reloads
       [view @match]))])

;; frontend routes
(def routes
  ;; ::index => :curr-ns/index
  ;; == client.router/index
  [["/" {:name ::index,
         :view index/index-page,
         :text "Home"}]

   ["/about" {:name ::about,
              :view about/about-page,
              :text "About"}]])

;; router fn optionally accepts a 3rd arg
;; which is a map
(def router
  (rf/router routes {:data {}}))

;; to run before the app-mounting
(defn init-router []
  (rfe/start!
   router
   on-navigate
   {:use-fragment true}))

;; component to pass to rdom/render in app.cljs
(defn router-component []
  [current-page ::index ::about])
