(ns job-search-amp.view.layout
  (:require [clojure.data.json :as json]
            [garden.core :as garden]
            [hiccup.core :as hiccup]))

(def ^:private amp-boilerplate-style
  "body{-webkit-animation:-amp-start 8s steps(1,end) 0s 1 normal both;-moz-animation:-amp-start 8s steps(1,end) 0s 1 normal both;-ms-animation:-amp-start 8s steps(1,end) 0s 1 normal both;animation:-amp-start 8s steps(1,end) 0s 1 normal both}@-webkit-keyframes -amp-start{from{visibility:hidden}to{visibility:visible}}@-moz-keyframes -amp-start{from{visibility:hidden}to{visibility:visible}}@-ms-keyframes -amp-start{from{visibility:hidden}to{visibility:visible}}@-o-keyframes -amp-start{from{visibility:hidden}to{visibility:visible}}@keyframes -amp-start{from{visibility:hidden}to{visibility:visible}}")

(def ^:private schema-json
  (json/write-str {"@context" "http://schema.org"
                   "@type" "NewsArticle"
                   "headeline" "Open-source framework for publishing content"
                   "datePublished" "2015-10-07T12:02:41Z"
                   "image" ["logo.jpg"]}))

(def ^:private custom-style
  (garden/css [:body {:background-color "#f1f1f1"}]))

(defn html-amp [& body-content]
  (hiccup/html
   {:mode :html}
   "<!doctype html>\n"
   [:html
    {:amp ""}
    [:head
     [:meta {:charset "utf-8"}]
     [:title "Hello, AMP"]
     [:link {:rel "canonical" :href "http://example.ampproject.org/article-metadata.html"}]
     [:meta {:name "viewport" :content "width=device-width,minimum-scale=1,initial-scale=1"}]
     [:script {:type "application/ld+json"} schema-json]
     [:style {:amp-boilerplate ""} amp-boilerplate-style]
     [:noscript
      [:style {:amp-boilerplate ""}
       "body{-webkit-animation:none;-moz-animation:none;-ms-animation:none;animation:none}"]]
     [:script {:async "" :src "https://cdn.ampproject.org/v0.js"}]
     [:style {:amp-custom ""} custom-style]]
    [:body
     body-content]]))
