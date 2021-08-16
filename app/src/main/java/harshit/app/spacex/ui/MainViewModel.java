package harshit.app.spacex.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import harshit.app.spacex.Utils.calback.ResponseCallback;
import harshit.app.spacex.database.AppDatabase;
import harshit.app.spacex.database.Dao.AppDao;
import harshit.app.spacex.model.CrewMember;
import harshit.app.spacex.repository.Repository;

public class MainViewModel extends AndroidViewModel {

    Repository repository;
    AppDao dao;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application.getApplicationContext());
        dao = AppDatabase.getInstance(application).dao();
    }

    public LiveData<List<CrewMember>> getAllCrewMember() {
        return dao.getAllCrewMember();
    }

    public void refreshData() {
        repository.fetchCrewMember();
    }

    public void deleteAll() {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            dao.deleteAll();
        });
    }

    public void setResponseListener(ResponseCallback listener) {
        repository.setCallback(listener);
    }
}
