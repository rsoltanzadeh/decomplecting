(ns decomplecting.router)

(defn path->location [path]
  (case path
    "/"     {:page-id :pages/frontpage}
    "/test" {:page-id :pages/test}
    nil))
