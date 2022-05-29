(ns client.pages.about
  "About page for the site."
  (:require
   [client.components.nav :refer [top-nav]]
   [client.components.header :refer [about-header]]
   [client.components.footer :refer [footer-frame]]
   ))

(def ^:private background
  "Since the outbreak of COVID-19, NYU Shanghai library has seen an increasing demand for scan of book chapters or  pages.")

(def ^:private reasons
  "This is partly because many courses have moved online and partly because the shipping channels have been significantly disrupted. In such cases, scanning a small part of a book for courses has proven to be a faster and more flexible solution.")

(def ^:private problem
  "However, as the number of the scanned files grows over time, it becomes harder for the library staff to track:")

(def ^:private challenges
  [
   "Which chapter (or part) from which book has been scanned?",
   "Where is a specific scan stored in Google Drive?"
   ])

(def ^:private aim
  "This project aims to solve the above problem.")

(def ^:private thanks-jade
  "I would like to express my appreciation to Jade, the student worker at NYU Shanghai Library, for her invaluable contribution to the database of this application. At the initial stage of this project, she loaded hundreds of entries into the master spreadsheet which later functioned as the main source of the database. This project would have been impossible without her effort and dedication.")

(def ^:private thanks-tianshu
  "I would also like to thank Tianshu. His advice on the selection of tech stack for this project has been a great souce of help and inspiration.")

(def ^:private thanks-alpox
  "Lastly, I wish to acknowledge the help provided by Elias Bernhaut (alpox in Clojure Slack) for his/her reviewing my code and pinning down the bugs on the frontend routing! That saved me from painful confusion and frustration.")

(defn about-para
  "Paragraphs on the about page."
  [txt]
  [:p.w-full.mx-auto.my-1.px-1.text-sm.sm:text-base
    txt])

(defn about-page
  "The frame holding content for the about page."
  []
  [:div.flex.flex-col.w-screen.h-screen
   [top-nav "about"]

   ;; motivation
 [:div.w-near.md:w-meet.lg:w-half.flex.flex-col.justify-center.p-4.mx-auto
    [about-header "Motivation"]
    [about-para background]
    [about-para reasons]
    [about-para problem]
    [:ul.list-disc.w-near.pl-4.mx-auto.my-1.text-sm.sm:text-base
     (for [cha challenges]
       ^{:key cha}
       [:li.normal cha])]
    [about-para aim]]

   ;; thanks
   [:div.w-near.md:w-meet.lg:w-half.flex.flex-col.justify-center.py-2.px-2.mx-auto.mb-6
    [about-header "Thanks"]
    [about-para thanks-jade]
    [about-para thanks-tianshu]
    [about-para thanks-alpox]]

   ;; footer
   [footer-frame "about"]
   ]
  )
