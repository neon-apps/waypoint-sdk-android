package com.neonapps.waypointsdk

import com.neonapps.waypointsdk.Models.*
import com.neonapps.waypointsdk.Models.Menu.Allergen
import com.neonapps.waypointsdk.Models.Menu.Category
import com.neonapps.waypointsdk.Models.Order.Order
import com.neonapps.waypointsdk.Models.Users.User

class Globals {

    companion object {
        // Seçili restorandaki tüm masaları barındırıyor (Waiter, Kitchen, Restaurant)
        var arrTables = mutableListOf<Table>()

        // Seçili restorandaki tüm siparişleri barındırıyor (Waiter, Kitchen, Restaurant)
        var arrOrders = mutableListOf<Order>()

        // Restoran ve waiter panelinge restoranın aldığı tüm rezervasyonları, müşteri panelinde ise müşterinin yaptığı tüm rezervasyonları barındırıyor. (Restaurant + Customer)
        var arrReservations = mutableListOf<Reservation>()

        // Uygulamada mevcut olan tüm allerjenler listesi. Bizim tarafımızdan firebase eklenecek ve oradan çekilecek. (All Panels)
        var arrAllergens = mutableListOf<Allergen>()

        // Uygulamada mevcut olan tüm special day'ler. Bizim tarafımızdan firebase eklenecek ve oradan çekilecek.
        var arrSpecialDays = mutableListOf<String>()

        // Restoran tarafından eklenen bütün feature'leri barındırıyor. (Waiter, Restaurant)
        var arrFeatures = mutableListOf<String>()

        // Restoran tarafından eklenen bütün kategoriler ve içindeki bütün yiyecekleri barındırıyor.  (Waiter, Kitchen, Restaurant)
        var arrCategories = mutableListOf<Category>()

        // Restoran tarafından eklenen bütün section'lari barındırıyor. (Restaurant Panel)
        var arrSections = mutableListOf<String>()

        // Garsonlar için tüm taskleri barındırıyor. (Waiter Panel)
        var arrTasks = mutableListOf<Task>()

        // Tüm bildirimleri barındırıyor. (All Panels)
        var arrNotifications = mutableListOf<PushNotification>()

        // Tüm restorantları barındırıyor. (Customer)
        var arrRestaurants = mutableListOf<Restaurant>()

        // Restorandaki tüm user'ları barındırıyor. (Restaurant)
        var arrUsers = mutableListOf<User>()

        // Kullanıcının kayıtlı kartları ve seçili kart
        var arrCards = mutableListOf<Card>()
        var selectedCard : Card? = null
    }
}