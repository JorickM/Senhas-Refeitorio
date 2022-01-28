<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateMealsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('meals', function (Blueprint $table) {
            $table->integer('codMeal')->autoIncrement()->primary();
            $table->integer('codWeekday')->unsigned();
            $table->string('mainDish');
            $table->string('soup');
            $table->string('desert');
            //$table->foreign('codWeekday')->references('codWeekday')->on('weekdays');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('meals');
    }
}
