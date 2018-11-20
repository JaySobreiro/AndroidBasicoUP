package com.example.ti.cadastrobd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.ListView;

public class DisciplinaDAO {

    private DBHelper helper;
    private DBGateway gateway;

    public DisciplinaDAO(Context context){
        gateway = DBGateway.getInstance(context);
    }

    public boolean cadastrarDisciplina(Disciplina d){

        ContentValues values = new ContentValues();
        long result;

        values.put(helper.NOME, d.getNome());
        values.put(helper.PROFESSOR, d.getProfessor());
        values.put(helper.TURNO, d.getTurno());
        values.put(helper.DIAS, d.getDias());

        result = gateway.getDatabase().insert(helper.TABLE,
                null, values);

        if(result > 0){
            return true;
        }

        return false;
    }


    public void getDisciplinas(){

        Cursor cursor = gateway.getDatabase().rawQuery(
                "SELECT * FROM " + helper.TABLE,
                null);

        try{

            cursor.moveToFirst();

            while (cursor != null){

                int id = cursor.getInt(cursor.getColumnIndex(helper.ID));
                String nome = cursor.getString(cursor.getColumnIndex(helper.NOME));
                String professor = cursor.getString(cursor.getColumnIndex(helper.PROFESSOR));
                String turno = cursor.getString(cursor.getColumnIndex(helper.TURNO));
                String dias = cursor.getString(cursor.getColumnIndex(helper.DIAS));

                ListaDisciplinas.addDisciplina(new Disciplina(id, nome, professor,
                        turno, dias));
                cursor.moveToNext();

            }
            cursor.close();


        }catch(Exception e) {
            e.printStackTrace();
        }

    }


    public boolean excluirDisciplina(int id){

        String where = helper.ID + " = ?";
        String[] args = {String.valueOf(id)};

        long result;

        result = gateway.getDatabase().delete(helper.TABLE, where, args);
        //gateway.getDatabase().execSQL("DELETE FROM disciplinas WHERE id = " + id);

        if(result > 0){
            return true;
        }

        return false;
    }

    public boolean atulizarDisciplina(Disciplina d){

        String where = helper.ID + " = ?";
        String[] args = {String.valueOf(d.getId())};
        ContentValues values = new ContentValues();

        values.put(helper.NOME, d.getNome());
        values.put(helper.PROFESSOR, d.getProfessor());
        values.put(helper.DIAS, d.getDias());
        values.put(helper.TURNO, d.getTurno());

        long result;

        result = gateway.getDatabase().update(helper.TABLE, values, where, args);

        if (result > 0){
            return true;
        }

        return false;
    }








;








}
