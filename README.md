# Currency Converter App

A simple currency converter application built with Kotlin for Android. The app allows users to convert currencies, view live exchange rates, and toggle offline mode to use stored data instead of fetching from the API. It includes a sleek UI with features such as a settings page, offline mode support, and a currency conversion tool.

---

## **App Structure**

### **1. Fragments**
- **ConvertFragment**:  
  Allows users to input an amount, select currencies to convert between, and view the converted result.
  
- **LiveExchangeRatesFragment**:  
  Displays live exchange rates fetched from the API or loaded from locally stored data when offline mode is enabled.

- **SettingsFragment**:  
  Contains a toggle for offline mode, allowing the user to prevent API calls and use stored exchange rates.

---

### **2. Features**
1. **Currency Conversion**:  
   Converts a user-entered amount from one currency to another based on real-time or locally stored rates.
2. **Live Exchange Rates**:  
   Fetches and displays live currency exchange rates from the API.
3. **Offline Mode**:  
   Saves fetched exchange rates locally and allows usage without an internet connection.
4. **Settings**:  
   Toggle offline mode on or off to control data fetching behavior.

---

## **Steps to Build and Run**

### **1. Prerequisites**
- Android Studio installed ([Download Android Studio](https://developer.android.com/studio))
- Minimum Android SDK version: 28 (Pie)
- API key for Exchange Rates API ([Sign up here](https://exchangeratesapi.io/))

---

### **2. Clone the Repository**
```bash
git clone https://github.com/EdgynCode/CurrencyConverter.git
cd CurrencyConverter
```

---

### **3. Configure the API Key**
- Open the file containing the API configuration (LiveExchangeRatesFragment.kt)
- Replace the placeholder with your actual API key.
```kotlin
private var apiKey = "your_api_key"
```

### **4. Open in Android Studio**
- Launch Android Studio.
- Click on Open and select the project folder.
- Sync Gradle by clicking Sync Now when prompted.

### **5. Run the App**
- Connect an Android device or set up an emulator.
- Click the Run button in Android Studio or press Shift + F10.
- The app will build and launch on the selected device or emulator.

### **Dependencies**
- Retrofit: For making API calls.
- Gson: For JSON serialization and deserialization.
- AndroidX: For modern Android UI components like Fragment and RecyclerView.

### **Challenges encountered**
- Using free API with limited features (limit request count, can't access convert API, can't change base currency).
- First ever project with Kotlin.
- Difficult to design screen layout (more diffcult than React Native).

### **Demo video**
([Demo video](https://drive.google.com/file/d/1M8cbROlm8NwgcIJf6hvKPlZNUZa49ql7/view?usp=sharing))
