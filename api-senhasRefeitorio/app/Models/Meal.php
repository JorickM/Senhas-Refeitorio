<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Meal extends Model
{
    use HasFactory;

    protected $primaryKey = 'codMeal';

    protected $table = 'meals';

    protected $fillable = ['codWeekday', 'mainDish', 'soup', 'desert', 'url'];
}
