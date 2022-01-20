<?php

use App\Http\Controllers\MealController;
use App\Http\Controllers\MealTypeController;
use App\Http\Controllers\WeekDayController;
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

Route::get('meals', [MealController::class, 'index']);
Route::get('meals/{codMeal}', [MealController::class, 'show']);
Route::post('meals', [MealController::class, 'create']);
Route::put('meals/{codMeal}', [MealController::class, 'update']);
Route::delete('meals/{codMeal}', [MealController::class, 'destroy']);

Route::get('mealtype', [MealTypeController::class, 'index']);
Route::get('mealtype/{codMealType}', [MealTypeController::class, 'show']);
Route::post('mealtype', [MealTypeController::class, 'create']);
Route::put('mealtype/{codMealType}', [MealTypeController::class, 'update']);
Route::delete('mealtype/{codMealType}', [MealTypeController::class, 'destroy']);

Route::get('purchases', [PurchaseController::class, 'index']);
Route::get('purchases/{codPurchase}', [PurchaseController::class, 'show']);
Route::post('purchases', [PurchaseController::class, 'create']);
Route::put('purchases/{codPurchase}', [PurchaseController::class, 'update']);
Route::delete('purchases/{codPurchase}', [PurchaseController::class, 'destroy']);

Route::get('user', [UserController::class, 'index']);
Route::get('user/{codUser}', [UserController::class, 'show']);
Route::post('user', [UserController::class, 'create']);
Route::put('user/{codUser}', [UserController::class, 'update']);
Route::delete('user/{codUser}', [UserController::class, 'destroy']);

Route::get('weekday', [WeekDayController::class, 'index']);
Route::get('weekday/{codWeekday}', [WeekDayController::class, 'show']);
Route::post('weekday', [WeekDayController::class, 'create']);
Route::put('weekday/{codWeekday}', [WeekDayController::class, 'update']);
Route::delete('weekday/{codWeekday}', [WeekDayController::class, 'destroy']);