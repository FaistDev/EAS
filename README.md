# EAS

Klassendiagramme:

ANLANGENVZ_Anlage
-name: String
-av: double
-date: LocalDate
-duration: double
+ANLANGENVZ_Anlage(name,av,date,duration): void
+GETTER

ANLANGENVZ_BL
-facilities: ArrayList
-COLNAMES: String[]
+calculate:void
+load: void
+save: void

ANLANGENVZ_RENDERER

ANLANGENVZ_GUI