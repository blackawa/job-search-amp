(ns job-search-amp.handler.example
  (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response] 
            [clojure.java.io :as io]
            [integrant.core :as ig]))

(defmethod ig/init-key :job-search-amp.handler/example [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok (io/resource "job_search_amp/handler/example/example.html")]))
