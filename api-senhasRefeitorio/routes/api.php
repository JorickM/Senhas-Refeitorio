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


Route::post('logins', [LoginController::class, 'postLoginByEmailPassword']);

Route::get('weekdays',[WeekdayController::class,'getAllWeekdays']);

Route::get('meals',[MealController::class,'getAllMeals']);

Route::get('purchases/all',[PurchaseController::class,'showAll']);
Route::get('purchases/byUser/{codUser}',[PurchaseController::class,'getPurchasesForUser']);
Route::post('purchases',[PurchaseController::class,'addNew']);
Route::put('purchases/',[PurchaseController::class,'updatePurchase']);
