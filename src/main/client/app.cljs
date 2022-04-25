(ns client.app
  (:require
   [ajax.core :refer [POST GET]]
   [goog.dom :as gdom]
   [reagent.dom :as rdom]
   [client.components.nav :as nav]
   [client.components.header :as hd]
   [client.pages.index :as index]))

(defn render-nav []
  (rdom/render
   [nav/nav-bar-frame]
   (.getElementById js/document "top-nav")))

(defn render-header []
  (rdom/render
   [hd/site-header]
   (.getElementById js/document "header")))

(defn render-search []
  (rdom/render
    [index/search-box]
    ;; (js/document.getElementById "app")
    (. js/document (getElementById "app"))))

(defn -main []
  (.log js/console "App started!")
  (render-nav)
  (render-header)
  (render-search))

(defn after-load! []
  (.log js/console "Page refreshed!")
  (render-nav)
  (render-header)
  (render-search))
