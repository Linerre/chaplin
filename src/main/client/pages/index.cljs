(ns client.pages.index
  "Index page."
  (:require
   [client.components.nav :refer [top-nav]]
   [client.components.header :refer [index-description]]
   [client.components.search :refer [search-frame]]
   [client.components.footer :refer [footer-frame]]
   [reitit.frontend.easy :as rfe]
   [re-frame.core :as re-frame]))

;; A page should be independent of any other pages
;; A page should return a view fn for router to use
(defn index-page
  "Index page."
  []
  [:div.h-screen.w-screen.flex.flex-col.justify-center.relative.overflow-hidden
   [:div.w-full.h-20.flex-none.flex.justify-center.items-ceneter
    [top-nav]]

   [:div.flex-1.py-10.flex.flex-col.justify-start.items-center
    [:div.h-20]
    [index-description]
    [search-frame]]

   [:div.w-full.flex-none
    [footer-frame "home"]]])
