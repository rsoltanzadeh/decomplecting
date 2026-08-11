(ns decomplecting.router)

(defn path->location [path]
  (case path
    "/"      {:page-id :pages/frontpage}
    "/setup" {:page-id :pages/setup}
    {:page-id :pages/not-found}))
