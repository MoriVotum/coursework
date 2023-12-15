import subprocess
import os

# Получаем текущий каталог
#current_directory = os.getcwd() + "/calculate"
current_directory = os.getcwd()
# Формируем путь к bash-скрипту
print(current_directory)
bash_script_path = os.path.join(current_directory, "Run.sh")
print(bash_script_path)

# Проверяем, существует ли файл Run.sh
if os.path.isfile(bash_script_path):
# Выполняем bash-скрипт
    try:
        subprocess.run(["bash", bash_script_path], check=True)
    except subprocess.CalledProcessError as e:
        print(f"Ошибка при выполнении скрипта: {e}")
else:
    print("Файл Run.sh не найден в текущем каталоге.")
