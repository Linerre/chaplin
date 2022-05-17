(ns client.pages.index
  "Index page."
  (:require
   [client.components.nav :refer [top-nav]]
   [client.components.header :refer [index-header]]
   [client.components.search :refer [search-frame]]
   [client.components.footer :refer [footer-frame]]
   ))

;; A page should be independent of any other pages
;; A page should return a view fn for router to use
(defn index-page
  "Index page."
  []
  [:div#app.min-h-screen.w-screen.relative
   [top-nav]
   [index-header]
   [search-frame]
   [footer-frame "home"]])
