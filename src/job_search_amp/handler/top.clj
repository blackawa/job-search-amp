(ns job-search-amp.handler.top
  (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response]
            [clojure.java.io :as io]
            [integrant.core :as ig]
            [job-search-amp.view.layout :as layout]))

(defn- top []
  (layout/html-amp
   [:div.container
    [:nav
     [:h1 "マッハアンプ"]]
    [:section
     [:amp-img {:src "rippotai.jpg" :alt "rippotai" :height "400" :width "400"}]
     [:p "検索しよう！"]]]))

(defmethod ig/init-key :job-search-amp.handler/top [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok (top)]))
