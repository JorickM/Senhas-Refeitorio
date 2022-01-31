<?php

use App\Http\Controllers\LoginController;
use App\Http\Controllers\MealController;
use App\Http\Controllers\PurchaseController;
use App\Http\Controllers\WeekdayController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

//Route::resource('logins','LoginController');
//Route::get('logins/getLoginByEmailPassword', 'LoginController@getLoginByEmailPassword');

//Route::get('logins',[LoginController::class,'index']);
//Route::get('logins/{codUser}',[LoginController::class,'show']);
//Route::post('logins/create',[LoginController::class,'create']);
//Route::put('logins/',[LoginController::class,'update']);
//Route::delete('logins/{codUser}',[LoginController::class,'destroy']);
Route::post('logins', [LoginController::class, 'postLoginByEmailPassword']);
//Route::get('logins/getAll',[LoginController::class,'getAll']);


//Route::post('weekdays',[WeekdayController::class,'create']);
Route::get('weekdays',[WeekdayController::class,'getAllWeekdays']);
//Route::get('weekdays/{codWeekday}',[WeekdayController::class,'show']);
//Route::put('weekdays/',[WeekdayController::class,'update']);
//Route::delete('weekdays/{codWeekday}',[WeekdayController::class,'destroy']);

Route::get('meals',[MealController::class,'getAllMeals']);
//Route::get('meals/{codMeal}',[MealController::class,'show']);
//Route::post('meals',[MealController::class,'create']);
//Route::put('meals/',[MealController::class,'update']);
//Route::delete('meals/{codMeal}',[MealController::class,'destroy']);

Route::get('purchases/all',[PurchaseController::class,'index']);
Route::get('purchases/byUser/{codUser}',[PurchaseController::class,'byUser']);
Route::get('purchases/{codPurchase}',[PurchaseController::class,'show']);
Route::post('purchases',[PurchaseController::class,'create']);
Route::put('purchases/',[PurchaseController::class,'update']);
Route::delete('purchases/{codPurchase}',[PurchaseController::class,'destroy']);