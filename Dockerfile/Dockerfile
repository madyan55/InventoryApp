# استخدم صورة أساسية من جافا 17
FROM mcr.microsoft.com/devcontainers/java:17

# تثبيت Gradle
RUN apt-get update && apt-get install -y gradle

# تثبيت Android SDK
RUN apt-get install -y wget unzip && \
    wget https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip -O sdk-tools.zip && \
    mkdir -p /usr/local/android-sdk && \
    unzip sdk-tools.zip -d /usr/local/android-sdk && \
    rm sdk-tools.zip

ENV ANDROID_HOME=/usr/local/android-sdk
ENV PATH=$ANDROID_HOME/cmdline-tools/bin:$PATH

# تثبيت SQLite
RUN apt-get install -y sqlite3

# تثبيت أدوات CI/CD (GitHub CLI + curl)
RUN apt-get install -y gh curl

# إعداد مجلد العمل
WORKDIR /workspace

# أمر افتراضي
CMD ["bash"]
