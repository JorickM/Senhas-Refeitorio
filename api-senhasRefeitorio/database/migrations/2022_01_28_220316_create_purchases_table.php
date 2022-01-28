<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreatePurchasesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('purchases', function (Blueprint $table) {
            $table->integer('codPurchase')->autoIncrement()->primary();
            $table->integer('codMeal')->unsigned();
            $table->integer('codUser')->unsigned();
            $table->timestamps();

            //$table->foreign('codMeal')->references('codMeal')->on('meals');
            //$table->foreign('codUser')->references('codUser')->on('logins');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('purchases');
    }
}
