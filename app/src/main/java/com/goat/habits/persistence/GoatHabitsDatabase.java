package com.goat.habits.persistence;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.goat.habits.persistence.dao.AchievementDAO;
import com.goat.habits.persistence.dao.HabitDAO;
import com.goat.habits.persistence.model.AchievementModel;
import com.goat.habits.persistence.model.HabitModel;

@Database(entities = {AchievementModel.class, HabitModel.class}, version = GoatHabitsDatabase.VERSION_1)
public abstract class GoatHabitsDatabase extends RoomDatabase {

    public abstract AchievementDAO getAchievementDAO();
    public abstract HabitDAO getHabitDAO();

    private static GoatHabitsDatabase DB_INSTANCE;
    final static int VERSION_1 = 1;

    private static final String INSERT_DEFAULT_ACHIEVEMENTS = "INSERT INTO achievements (name, description, type) VALUES " +
            "('Engatinhando', 'Conclua 5 Hábitos', 'Comum' )," +
            "('Primeiros passos', 'Conclua 10 Hábitos', 'Comum')," +
            "('Iniciante', 'Conclua 20 Hábitos', 'Raro')," +
            "('Intermediário', 'Conclua 30 Hábitos', 'Raro')," +
            "('Experiente', 'Conclua 50 Hábitos', 'Raro')," +
            "('Mestre da rotina', 'Conclua 80 Hábitos', 'Épico')," +
            "('Poder do Hábito!', 'Conclua 100 Hábitos', 'Épico')," +
            "('Lendário', 'Conclua 150 Hábitos', 'Épico')," +
            "('Herócio!', 'Conclua 200 Hábitos', 'Monstro')," +
            "('Cbum', 'Conclua 300 Hábitos', 'Monstro')";


    public static synchronized GoatHabitsDatabase getDbInstance(Context context){
        if (DB_INSTANCE == null){
            DB_INSTANCE = Room.databaseBuilder(context.getApplicationContext(), GoatHabitsDatabase.class, "goat_habits_db")
                    .allowMainThreadQueries()
                    .addCallback(new RoomDatabase.Callback(){
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            //Seta valores default para as conquistas
                            db.execSQL(INSERT_DEFAULT_ACHIEVEMENTS);
                        }
                    })
                    .build();
        }
        return  DB_INSTANCE;
    }

}
