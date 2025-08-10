import os


class FileUtils:
    @staticmethod
    def remove_file(file_path):
        if os.path.isfile(file_path):
            os.remove(file_path)